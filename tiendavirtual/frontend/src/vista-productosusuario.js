import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaProductosusuario extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 48%;
        			margin-right: 1%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%; flex-direction: row; justify-content: center; flex-wrap: wrap; align-content: flex-start; align-items: flex-start; margin: var(--lumo-space-m);" id="horizontalProductos"></vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-productosusuario';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProductosusuario.is, VistaProductosusuario);
