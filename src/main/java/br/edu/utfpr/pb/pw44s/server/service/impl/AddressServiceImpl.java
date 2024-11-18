package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.repository.AddressRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IAddressService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends CrudServiceImpl<Address, Long>
        implements IAddressService {
    private AddressRepository addressRepository;
    private AuthService authService;

    public AddressServiceImpl(AddressRepository addressRepository, AuthService authService) {
        this.addressRepository  = addressRepository;
        this.authService  = authService;
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    public List<Address> findByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }


    @Override
    public Address save(Address entity) {
        entity.setUser(authService.getAuthenticatedUser());
        return super.save(entity);
    }
}
