import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-select/src/vaadin-select.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

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
 <vaadin-horizontal-layout class="content" id="principal" theme="spacing">
  <vaadin-horizontal-layout theme="spacing" id="fotos">
   <img id="image1" style="width: 100px; height: 100px;">
   <img id="image2" style="width: 100px; height: 100px;">
   <img id="image3" style="width: 100px; height: 100px;">
   <img id="image4" style="width: 100px; height: 100px;">
   <img id="image5" style="width: 100px; height: 100px;">
  </vaadin-horizontal-layout>
  <vaadin-text-field label="Precio" placeholder="Placeholder" id="precio" readonly></vaadin-text-field>
  <vaadin-button id="addCarritoButton">
   Agregar al carrito 
  </vaadin-button>
  <vaadin-select value="Item one" id="cantidad">
   <template>
    <vaadin-list-box>
     <vaadin-item>
       Item one 
     </vaadin-item>
     <vaadin-item>
       Item two 
     </vaadin-item>
     <vaadin-item>
       Item three 
     </vaadin-item>
    </vaadin-list-box>
   </template>
  </vaadin-select>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="descripcion">
  <vaadin-text-field label="Descripción" placeholder="Placeholder" id="descripcionText" readonly></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="caracteristicas">
  <vaadin-text-field label="Características" placeholder="Placeholder" id="caracteristicasText" readonly></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="valoraciones"></vaadin-horizontal-layout>
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
