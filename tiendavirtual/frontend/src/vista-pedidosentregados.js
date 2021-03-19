import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-pedidosentregados`
 *
 * VistaPedidosentregados element.
 *
 * @customElement
 * @polymer
 */
class VistaPedidosentregados extends PolymerElement {

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
        return 'vista-pedidosentregados';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaPedidosentregados.is, VistaPedidosentregados);
