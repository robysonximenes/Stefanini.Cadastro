
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cadastrarPessoaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cadastrarPessoaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outCadastrarPessoa" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}outCadastrarPessoa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastrarPessoaResponse", propOrder = {
    "outCadastrarPessoa"
})
public class CadastrarPessoaResponse {

    protected OutCadastrarPessoa outCadastrarPessoa;

    /**
     * Gets the value of the outCadastrarPessoa property.
     * 
     * @return
     *     possible object is
     *     {@link OutCadastrarPessoa }
     *     
     */
    public OutCadastrarPessoa getOutCadastrarPessoa() {
        return outCadastrarPessoa;
    }

    /**
     * Sets the value of the outCadastrarPessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutCadastrarPessoa }
     *     
     */
    public void setOutCadastrarPessoa(OutCadastrarPessoa value) {
        this.outCadastrarPessoa = value;
    }

}
