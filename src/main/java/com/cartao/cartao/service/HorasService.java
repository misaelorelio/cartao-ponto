package com.cartao.cartao.service;

import com.cartao.cartao.model.Horas;
import com.cartao.cartao.repository.HorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Service
public class HorasService {

    @Autowired
    private HorasRepository horasRepository;

    LocalDate localDate = LocalDate.now();
    public Page<Horas> listarHorasr(Pageable pageable) {
        return horasRepository.listarHoras(pageable);
    }

    public Horas inserirHoras(Horas horas) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date hora = Calendar.getInstance().getTime();
        String dataFormatada = sdf.format(hora);
        var t = dataFormatada.split(":");
        //Falta tertminar verificação de horas
        if(horas != null) {
            horas.setHoraRegistrada(dataFormatada);
            horas.setDataRegistro(localDate);
            return horasRepository.save(horas);
        }else {
            throw new Exception();
        }
    }

    public Horas atualizarHoras(Horas horas) throws Exception {
        if(horas.getId() == null) {
            throw new Exception();
        }

        return horasRepository.save(horas);
    }
}
