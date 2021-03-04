import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './vista-productos_usuario.js';

class VistaElementos_comunes_pantalla_principal extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vista-productos_usuario id="vistaProductos_usuario" style="width: 100%;"></vista-productos_usuario>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-elementos_comunes_pantalla_principal';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaElementos_comunes_pantalla_principal.is, VistaElementos_comunes_pantalla_principal);
