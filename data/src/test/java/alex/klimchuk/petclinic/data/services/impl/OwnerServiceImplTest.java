package alex.klimchuk.petclinic.data.services.impl;

import alex.klimchuk.petclinic.data.model.Owner;
import alex.klimchuk.petclinic.data.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

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
class OwnerServiceImplTest {

    public static final String LAST_NAME = "Alex";
    public static final Long OWNER_ID = 1L;

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerServiceImpl ownerService;

    Owner ownerMock;

    @BeforeEach
    void setUp() {
        ownerMock = Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownersMock = new HashSet<>();
        ownersMock.add(Owner.builder().id(1L).build());
        ownersMock.add(Owner.builder().id(2L).build());

        when(ownerService.findAll()).thenReturn(ownersMock);

        Set<Owner> owners = ownerService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(ownerMock));

        Owner owner = ownerService.findById(OWNER_ID);

        assertNotNull(owner);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerService.findById(OWNER_ID);

        assertNull(owner);
    }

    @Test
    void findByLastName() {
        when(ownerService.findByLastName(LAST_NAME)).thenReturn(ownerMock);

        Owner owner = ownerService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(ownerMock);

        Owner owner = ownerService.save(ownerMock);

        assertNotNull(owner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerService.delete(ownerMock);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(OWNER_ID);

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

}