
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for atualizarPessoaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="atualizarPessoaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outAtualizarPessoa" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}outAtualizarPessoa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atualizarPessoaResponse", propOrder = {
    "outAtualizarPessoa"
})
public class AtualizarPessoaResponse {

    protected OutAtualizarPessoa outAtualizarPessoa;

    /**
     * Gets the value of the outAtualizarPessoa property.
     * 
     * @return
     *     possible object is
     *     {@link OutAtualizarPessoa }
     *     
     */
    public OutAtualizarPessoa getOutAtualizarPessoa() {
        return outAtualizarPessoa;
    }

    /**
     * Sets the value of the outAtualizarPessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutAtualizarPessoa }
     *     
     */
    public void setOutAtualizarPessoa(OutAtualizarPessoa value) {
        this.outAtualizarPessoa = value;
    }

}
