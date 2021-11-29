package br.com.zup.MiniProjetoModulo05Elegance.produto;


import br.com.zup.MiniProjetoModulo05Elegance.dtos.ProdutoDTO;
import br.com.zup.MiniProjetoModulo05Elegance.produto.Produto;
import br.com.zup.MiniProjetoModulo05Elegance.produto.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
}
