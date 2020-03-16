
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cadastrarPessoa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cadastrarPessoa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inCadastrarPessoa" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}inCadastrarPessoa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastrarPessoa", propOrder = {
    "inCadastrarPessoa"
})
public class CadastrarPessoa {

    protected InCadastrarPessoa inCadastrarPessoa;

    /**
     * Gets the value of the inCadastrarPessoa property.
     * 
     * @return
     *     possible object is
     *     {@link InCadastrarPessoa }
     *     
     */
    public InCadastrarPessoa getInCadastrarPessoa() {
        return inCadastrarPessoa;
    }

    /**
     * Sets the value of the inCadastrarPessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link InCadastrarPessoa }
     *     
     */
    public void setInCadastrarPessoa(InCadastrarPessoa value) {
        this.inCadastrarPessoa = value;
    }

}
