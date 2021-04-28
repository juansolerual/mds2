import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-select/src/vaadin-select.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';

class VistaProductousuario extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			margin: var(--lumo-space-m);
                }
            </style>
<vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" style="margin: var(--lumo-space-m);">
  <vaadin-text-field id="nombreProducto" placeholder="Nombre producto" style="align-self: flex-start; margin: var(--lumo-space-m);" label="Producto:">
    Label 
  </vaadin-text-field>
  <vaadin-text-field id="precio" placeholder="0.00€" style="align-self: flex-start; margin: var(--lumo-space-m);" label="Precio:">
    Label 
  </vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="content" id="principal" theme="spacing" style="margin: var(--lumo-space-m);">
  <vaadin-horizontal-layout theme="spacing" id="fotos">
   <img id="image1" style="width: 100px; height: 100px;">
   <img id="image2" style="width: 100px; height: 100px;">
   <img id="image3" style="width: 100px; height: 100px;">
   <img id="image4" style="width: 100px; height: 100px;">
   <img id="image5" style="width: 100px; height: 100px;">
  </vaadin-horizontal-layout>
  <vaadin-vertical-layout theme="spacing">
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-combo-box id="categoria1" label="Categoria"></vaadin-combo-box>
    <vaadin-combo-box id="oferta" label="oferta"></vaadin-combo-box>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-button id="buttonCrearCategoria">
      Crear categoria 
    </vaadin-button>
    <vaadin-button id="buttonCrearOferta">
      Crear oferta 
    </vaadin-button>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
  <vaadin-combo-box label"Cantidad" id="cantidad">
   </vaadin-combo-box>
  <vaadin-button id="addCarritoButton">
    Agregar al carrito 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="descripcion" style="width:100%; margin: var(--lumo-space-m);">
  <vaadin-text-area label="Descripción" style="width:100%; margin: var(--lumo-space-m); placeholder=" decripción" id="descripcionText" readonly></vaadin-text-area>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="caracteristicas" style="width:100%; margin: var(--lumo-space-m);">
  <vaadin-text-area label="Características" style="width:100%; margin: var(--lumo-space-m); placeholder=" caracteristicas" id="caracteristicasText" readonly></vaadin-text-area>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width:100%; margin: var(--lumo-space-m);" id="valoraciones"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-productousuario';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProductousuario.is, VistaProductousuario);
