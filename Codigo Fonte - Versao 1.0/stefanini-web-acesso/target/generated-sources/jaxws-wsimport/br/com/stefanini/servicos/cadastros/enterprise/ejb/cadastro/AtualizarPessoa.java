
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for atualizarPessoa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="atualizarPessoa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inAtualizarPessoa" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}inAtualizarPessoa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atualizarPessoa", propOrder = {
    "inAtualizarPessoa"
})
public class AtualizarPessoa {

    protected InAtualizarPessoa inAtualizarPessoa;

    /**
     * Gets the value of the inAtualizarPessoa property.
     * 
     * @return
     *     possible object is
     *     {@link InAtualizarPessoa }
     *     
     */
    public InAtualizarPessoa getInAtualizarPessoa() {
        return inAtualizarPessoa;
    }

    /**
     * Sets the value of the inAtualizarPessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link InAtualizarPessoa }
     *     
     */
    public void setInAtualizarPessoa(InAtualizarPessoa value) {
        this.inAtualizarPessoa = value;
    }

}
