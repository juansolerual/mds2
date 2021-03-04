import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-vista_pedidos_entregados`
 *
 * VistaVista_pedidos_entregados element.
 *
 * @customElement
 * @polymer
 */
class VistaVista_pedidos_entregados extends PolymerElement {

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
        return 'vista-vista_pedidos_entregados';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVista_pedidos_entregados.is, VistaVista_pedidos_entregados);
