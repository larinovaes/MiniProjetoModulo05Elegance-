package br.com.zup.MiniProjetoModulo05Elegance.produto;


import br.com.zup.MiniProjetoModulo05Elegance.dtos.ProdutoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO salvarProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produtoService.cadastoProduto(produto);
        produtoDTO = modelMapper.map(produto, ProdutoDTO.class);

        return produtoDTO;
    }

    @GetMapping
    public List<ProdutoDTO> exibirListaDeProdutos() {
        List<ProdutoDTO> produtos = new ArrayList<>();
        for (Produto referencia : produtoService.exibirListaDeProdutos()) {
            ProdutoDTO produtoDTO = modelMapper.map(referencia, ProdutoDTO.class);
            produtos.add(produtoDTO);
        }
        return produtos;
    }
}
