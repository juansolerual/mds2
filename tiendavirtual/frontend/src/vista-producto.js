import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaProducto extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; justify-content: center; align-items: center; flex-direction: column; padding: var(--lumo-space-m); margin: var(--lumo-space-m);">
 <vaadin-item id="vaadinItem" style="width: 100%; height: 100%;">
  <img id="img" style="width: 100%; height: 100%; align-self: center;">Text 
 </vaadin-item>
 <vaadin-button style="width: 100%; margin: var(--lumo-space-m);" id="anadirCarrito">
   Añadir a carrito 
 </vaadin-button>
 <vaadin-button style="width: 100%;" id="editarProducto">
   Editar producto 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-producto';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProducto.is, VistaProducto);
