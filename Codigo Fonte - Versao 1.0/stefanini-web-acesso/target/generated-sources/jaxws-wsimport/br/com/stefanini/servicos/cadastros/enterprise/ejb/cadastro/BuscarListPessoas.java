
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarListPessoas complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarListPessoas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inBuscarPessoa" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}inBuscarPessoa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarListPessoas", propOrder = {
    "inBuscarPessoa"
})
public class BuscarListPessoas {

    protected InBuscarPessoa inBuscarPessoa;

    /**
     * Gets the value of the inBuscarPessoa property.
     * 
     * @return
     *     possible object is
     *     {@link InBuscarPessoa }
     *     
     */
    public InBuscarPessoa getInBuscarPessoa() {
        return inBuscarPessoa;
    }

    /**
     * Sets the value of the inBuscarPessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link InBuscarPessoa }
     *     
     */
    public void setInBuscarPessoa(InBuscarPessoa value) {
        this.inBuscarPessoa = value;
    }

}
