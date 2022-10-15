/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Machine;
import com.example.demo.Repositorio.MachineRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mateo
 */
@Service
public class MachineServicio {

    @Autowired
    private MachineRepositorio machineRepository;

    public List<Machine> getAll() {
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(int machineId) {
        return machineRepository.getMachine(machineId);
    }

    public Machine save(Machine machine) {

        if (machine.getId() == null) {
            return machineRepository.save(machine);
        } else {
            Optional<Machine> e = machineRepository.getMachine(machine.getId());
            if (e.isEmpty()) {
                return machineRepository.save(machine);
            } else {
                return machine;
            }
        }
    }

}
