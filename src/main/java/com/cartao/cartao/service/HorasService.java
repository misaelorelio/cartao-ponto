package com.cartao.cartao.service;

import com.cartao.cartao.model.Colaborador;
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
import java.util.List;

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

        var idUltimoRegistro = horas.getColaborador().getId();

        var dataRegistroPonto = localDate;
        List<Horas> registrosSalvaosBd = horasRepository.findByDataRegistroAndColaborador(dataRegistroPonto, idUltimoRegistro);

        if(horas == null) {
            throw new Exception();
        }
        else if(registrosSalvaosBd.isEmpty()) {
            horas.setHoraRegistrada(dataFormatada);
            horas.setDataRegistro(localDate);
            horas.setTipo(true);
            return horasRepository.save(horas);
        }
        else {
            for (Horas hr: registrosSalvaosBd) {
                if(horas.getHoraRegistrada() != hr.getHoraRegistrada()) {
                    if(hr.getTipo() == false) {
                               horas.setTipo(true);
                           }
                           else if( hr.getTipo() == true) {
                               horas.setTipo(false);
                           }
                }

            }
            horas.setHoraRegistrada(dataFormatada);
            horas.setDataRegistro(localDate);
            return horasRepository.save(horas);
        }
    }

    public Horas atualizarHoras(Horas horas) throws Exception {
        if(horas.getId() == null) {
            throw new Exception();
        }

        return horasRepository.save(horas);
    }
}
