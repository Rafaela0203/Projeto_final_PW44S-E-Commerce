package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.AddressDTO;
import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.service.IAddressService;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("addresses")
public class AddressController extends CrudController<Address, AddressDTO, Long> {
    private static IAddressService addressService;
    private static ModelMapper modelMapper;

    public AddressController(IAddressService addressService, ModelMapper modelMapper) {
        super(Address.class, AddressDTO.class);
        AddressController.addressService = addressService;
        AddressController.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<Address, Long> getService(){return AddressController.addressService;}

    @Override
    protected ModelMapper getModelMapper(){return AddressController.modelMapper;}
}
