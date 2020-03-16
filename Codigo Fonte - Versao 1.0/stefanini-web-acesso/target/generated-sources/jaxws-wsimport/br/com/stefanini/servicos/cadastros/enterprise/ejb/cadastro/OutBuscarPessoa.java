
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for outBuscarPessoa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="outBuscarPessoa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listPessoa" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="pessoa" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}pessoa" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="status" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}status" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outBuscarPessoa", propOrder = {
    "listPessoa",
    "status"
})
public class OutBuscarPessoa {

    protected OutBuscarPessoa.ListPessoa listPessoa;
    protected Status status;

    /**
     * Gets the value of the listPessoa property.
     * 
     * @return
     *     possible object is
     *     {@link OutBuscarPessoa.ListPessoa }
     *     
     */
    public OutBuscarPessoa.ListPessoa getListPessoa() {
        return listPessoa;
    }

    /**
     * Sets the value of the listPessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutBuscarPessoa.ListPessoa }
     *     
     */
    public void setListPessoa(OutBuscarPessoa.ListPessoa value) {
        this.listPessoa = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="pessoa" type="{http://cadastro.ejb.enterprise.cadastros.servicos.stefanini.com.br/}pessoa" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "pessoa"
    })
    public static class ListPessoa {

        protected List<Pessoa> pessoa;

        /**
         * Gets the value of the pessoa property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the pessoa property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPessoa().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Pessoa }
         * 
         * 
         */
        public List<Pessoa> getPessoa() {
            if (pessoa == null) {
                pessoa = new ArrayList<Pessoa>();
            }
            return this.pessoa;
        }

    }

}
