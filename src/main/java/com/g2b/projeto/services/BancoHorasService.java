package com.g2b.projeto.services;

import com.g2b.projeto.model.BancoHoras;
import com.g2b.projeto.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {

    BancoHorasRepository bancoHorasRepository;

    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    public BancoHoras saveBancoHoras(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public Optional<BancoHoras> getById(Long idBancoHoras) {
        return bancoHorasRepository.findById(idBancoHoras);
    }

    public BancoHoras updateBancoHoras(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public void deleteBancoHoras(Long idBancoHoras) {
        bancoHorasRepository.deleteById(idBancoHoras);
    }

    public List<BancoHoras> findAll() {
        return bancoHorasRepository.findAll();
    }
}
