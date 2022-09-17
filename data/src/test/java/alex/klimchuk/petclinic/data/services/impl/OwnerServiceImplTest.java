package alex.klimchuk.petclinic.data.services.impl;

import alex.klimchuk.petclinic.data.model.Owner;
import alex.klimchuk.petclinic.data.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@ExtendWith(MockitoExtension.class)
public class OwnerServiceImplTest {

    public static final String LAST_NAME = "Alex";
    public static final Long OWNER_ID = 1L;

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerServiceImpl ownerService;

    private Owner ownerMock;

    @BeforeEach
    public void setUp() {
        ownerMock = Owner.builder()
                .id(OWNER_ID)
                .lastName(LAST_NAME)
                .build();
    }

    @Test
    public void testFindAll() {
        Set<Owner> ownersMock = new HashSet<>();
        ownersMock.add(Owner.builder().id(1L).build());
        ownersMock.add(Owner.builder().id(2L).city("Brest").build());
        ownersMock.add(Owner.builder().id(3L).telephone("+375-29-999-29-29").build());

        when(ownerService.findAll()).thenReturn(ownersMock);

        Set<Owner> owners = ownerService.findAll();

        assertNotNull(owners);
        assertEquals(3, owners.size());
    }

    @Test
    public void testFindById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(ownerMock));

        Owner owner = ownerService.findById(OWNER_ID);

        assertNotNull(owner);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    public void testFindByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerService.findById(OWNER_ID);

        assertNull(owner);
    }

    @Test
    public void testFindByLastName() {
        when(ownerService.findByLastName(LAST_NAME)).thenReturn(ownerMock);

        Owner owner = ownerService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    public void testSave() {
        when(ownerRepository.save(any())).thenReturn(ownerMock);

        Owner owner = ownerService.save(ownerMock);

        assertNotNull(owner);
        verify(ownerRepository).save(any());
    }

    @Test
    public void testDelete() {
        ownerService.delete(ownerMock);

        verify(ownerRepository).delete(any());
    }

    @Test
    public void testDeleteById() {
        ownerService.deleteById(OWNER_ID);

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

}
