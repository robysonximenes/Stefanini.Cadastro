
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buscarListPessoasResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buscarListPessoasResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outBuscarPessoa" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}outBuscarPessoa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buscarListPessoasResponse", propOrder = {
    "outBuscarPessoa"
})
public class BuscarListPessoasResponse {

    protected OutBuscarPessoa outBuscarPessoa;

    /**
     * Gets the value of the outBuscarPessoa property.
     * 
     * @return
     *     possible object is
     *     {@link OutBuscarPessoa }
     *     
     */
    public OutBuscarPessoa getOutBuscarPessoa() {
        return outBuscarPessoa;
    }

    /**
     * Sets the value of the outBuscarPessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutBuscarPessoa }
     *     
     */
    public void setOutBuscarPessoa(OutBuscarPessoa value) {
        this.outBuscarPessoa = value;
    }

}
