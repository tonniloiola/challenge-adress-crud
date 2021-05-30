package br.com.tonni.controller;

import br.com.tonni.controller.exception.ResourceNotFoundException;
import br.com.tonni.data.AdressDto;
import br.com.tonni.ports.api.AdressServicePort;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class AdressRestController {

    @Autowired
    private AdressServicePort adressServicePort;

    @Operation(
            summary = "Retorna uma lista de endereços",
            description = "Retorna uma lista de endereços.",
            tags = {"Address"})
    @GetMapping(value = "/adress")
    public List<AdressDto> getAdress() {
        return adressServicePort.findAll();
    }

    @Operation(
            summary = "Retorna uma lista de endereços",
            description = "Retorna uma lista de endereços.",
            tags = {"Address"})
    @GetMapping(value = "/adressById/{adressId}")
    public AdressDto getAdressById(@PathVariable Long adressId) {
        return adressServicePort.findById(adressId);
    }

    @Operation(
            summary = "Cria um endereço.",
            description = "Cria um endereço.",
            tags = {"Address"})
    @PostMapping("/adress")
    public AdressDto createAdress(@Valid @RequestBody AdressDto adressDto) {
        return adressServicePort.save(adressDto);
    }

    @Operation(
            summary = "Atualiza um endereço.",
            description = "Atualiza um endereço.",
            tags = {"Address"})
    @PutMapping("/adress/{adressId}")
    public AdressDto updateAdressDto(@PathVariable Long adressId,
                                     @Valid @RequestBody AdressDto adressDtoRequest) {
        return adressServicePort.update(adressId, adressDtoRequest)
                .orElseThrow(() -> new ResourceNotFoundException("Adress not found with id " + adressId));
    }

    @Operation(
            summary = "Exclui um endereço.",
            description = "Exclui um endereço.",
            tags = {"Address"})
    @DeleteMapping("/adress/{adressId}")
    public void deleteAdress(@PathVariable Long adressId) {
        adressServicePort.delete(adressId);
    }
}

