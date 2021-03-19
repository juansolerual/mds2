import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaProductosadministrador extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                     display: block;
                    height: 100%;
        			width: 49%;
        			margin-right: 1%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%; margin: var(--lumo-space-m); flex-direction: row; align-items: flex-start; justify-content: center; flex-wrap: wrap; align-content: flex-start;" id="horizontalProductos"></vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-productosadministrador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaProductosadministrador.is, VistaProductosadministrador);
