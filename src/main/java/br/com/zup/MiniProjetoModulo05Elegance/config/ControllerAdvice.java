package br.com.zup.MiniProjetoModulo05Elegance.config;

import br.com.zup.MiniProjetoModulo05Elegance.exception.MensagemErro;
import br.com.zup.MiniProjetoModulo05Elegance.exception.PesquisarCpfException;
import br.com.zup.MiniProjetoModulo05Elegance.exception.PesquisarEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemErro> manipularErrosDeValidacao(MethodArgumentNotValidException exception) {
        List<MensagemErro> erros = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            MensagemErro mensagemErro = new MensagemErro(fieldError.getDefaultMessage());
            erros.add(mensagemErro);
        }

        return erros;
    }

    @ExceptionHandler(PesquisarEmailException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemErro tratarExcecaoPesquisarEmailException(PesquisarEmailException exception){
        return new MensagemErro(exception.getMessage());
    }

    @ExceptionHandler(PesquisarCpfException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemErro tratarExcecaoPesquisarCpfException(PesquisarCpfException exception){
        return new MensagemErro(exception.getMessage());
    }

}
