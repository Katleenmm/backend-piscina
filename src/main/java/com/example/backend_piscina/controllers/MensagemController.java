package com.example.backend_piscina.controllers;
import com.example.backend_piscina.dtos.MensagemDTO;
import com.example.backend_piscina.services.MensagemService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }



    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public MensagemDTO createMensagem(
            @RequestParam("idConversa") UUID idConversa,
            @RequestParam("remetente") String remetente,
            @RequestParam("conteudo_texto") String conteudo_texto,
            @RequestParam(value = "imagem", required = false) MultipartFile imagem) throws IOException {

        byte[] imagemBytes = null;
        if (imagem != null && !imagem.isEmpty()) {
            imagemBytes = imagem.getBytes();
        }

        return mensagemService.createMensagem(idConversa, remetente, conteudo_texto, imagemBytes);
    }



    @GetMapping("/conversa/{idConversa}")
    public List<MensagemDTO> getMensagensByConversa(@PathVariable UUID idConversa) {
        return mensagemService.getMensagensByConversa(idConversa);
    }
}
