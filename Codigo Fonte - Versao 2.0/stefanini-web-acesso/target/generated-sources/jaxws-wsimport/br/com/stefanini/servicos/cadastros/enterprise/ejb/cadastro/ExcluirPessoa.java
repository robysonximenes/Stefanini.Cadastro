
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for excluirPessoa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="excluirPessoa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inExcluirPessoa" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}inExcluirPessoa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "excluirPessoa", propOrder = {
    "inExcluirPessoa"
})
public class ExcluirPessoa {

    protected InExcluirPessoa inExcluirPessoa;

    /**
     * Gets the value of the inExcluirPessoa property.
     * 
     * @return
     *     possible object is
     *     {@link InExcluirPessoa }
     *     
     */
    public InExcluirPessoa getInExcluirPessoa() {
        return inExcluirPessoa;
    }

    /**
     * Sets the value of the inExcluirPessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link InExcluirPessoa }
     *     
     */
    public void setInExcluirPessoa(InExcluirPessoa value) {
        this.inExcluirPessoa = value;
    }

}
