package ps2.restapidb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class ParticipanteController {

    @Autowired
    private ParticipanteRepo participanteRepo;

    @GetMapping("/api/participantes")
    Iterable<Participante> getParticipantes() {
        return participanteRepo.findAll();
    }

    @GetMapping("/api/participantes/{id}")
    Optional<Participante> getParticipante(@PathVariable long id) {
        return participanteRepo.findById(id);
    }

    @PostMapping("/api/participantes")
    Participante createParticipante(@RequestBody Participante participante) {
        Participante createdParticipante = participanteRepo.save(participante);
        return createdParticipante;
    }

    @PutMapping("/api/participantes/{participanteId}")
    Optional<Participante> updateParticipante(@RequestBody Participante participanteReq, @PathVariable long participanteId) {
        Optional<Participante> opt = participanteRepo.findById(participanteId);
        if (opt.isPresent()) {
            if (participanteReq.getId_participante() == participanteId) {
                participanteRepo.save(participanteReq);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados do participante com id " + participanteId);
    }

    @DeleteMapping("/api/participantes/{id}")
    void deleteParticipante(@PathVariable long id) {
        participanteRepo.deleteById(id);
    }
}
