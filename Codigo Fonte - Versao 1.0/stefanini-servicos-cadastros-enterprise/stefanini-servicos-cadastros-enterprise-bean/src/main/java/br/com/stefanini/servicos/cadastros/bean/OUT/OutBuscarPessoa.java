package br.com.stefanini.servicos.cadastros.bean.OUT;

import br.com.stefanini.servicos.cadastros.bean.Pessoa;
import br.com.stefanini.servicos.cadastros.bean.Status;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;

/**
 * Stefanini 2020
 * @author Ximenes
 * Date 10/03/2020
 * Class Representa os atributos de saida/retorno do web servicer de Buscar Pessoas
 */
public class OutBuscarPessoa implements Serializable{
    private List<Pessoa> listPessoa;
    private Status status;

    /**
     * @return the listPessoa
     */
    @XmlElements({@XmlElement(name="pessoa",type=Pessoa.class)})
    @XmlElementWrapper(name="listPessoa")
    public List<Pessoa> getListPessoa() {
        return listPessoa;
    }

    /**
     * @param listPessoa the pessoa to set
     */
    public void setListPessoa(List<Pessoa> listPessoa) {
        this.listPessoa = listPessoa;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}
