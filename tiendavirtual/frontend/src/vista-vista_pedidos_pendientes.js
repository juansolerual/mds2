import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-vista_pedidos_pendientes`
 *
 * VistaVista_pedidos_pendientes element.
 *
 * @customElement
 * @polymer
 */
class VistaVista_pedidos_pendientes extends PolymerElement {

    static get template() {
        return html`
            <style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
        `;
    }

    static get is() {
        return 'vista-vista_pedidos_pendientes';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVista_pedidos_pendientes.is, VistaVista_pedidos_pendientes);
