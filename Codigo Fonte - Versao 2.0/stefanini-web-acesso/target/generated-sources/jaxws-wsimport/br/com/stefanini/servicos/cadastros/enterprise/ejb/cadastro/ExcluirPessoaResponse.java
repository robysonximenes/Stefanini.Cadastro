
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for excluirPessoaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="excluirPessoaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outExcluirPessoa" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}outExcluirPessoa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "excluirPessoaResponse", propOrder = {
    "outExcluirPessoa"
})
public class ExcluirPessoaResponse {

    protected OutExcluirPessoa outExcluirPessoa;

    /**
     * Gets the value of the outExcluirPessoa property.
     * 
     * @return
     *     possible object is
     *     {@link OutExcluirPessoa }
     *     
     */
    public OutExcluirPessoa getOutExcluirPessoa() {
        return outExcluirPessoa;
    }

    /**
     * Sets the value of the outExcluirPessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutExcluirPessoa }
     *     
     */
    public void setOutExcluirPessoa(OutExcluirPessoa value) {
        this.outExcluirPessoa = value;
    }

}
