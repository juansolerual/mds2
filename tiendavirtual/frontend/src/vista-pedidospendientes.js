import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-pedidospendientes`
 *
 * VistaPedidospendientes element.
 *
 * @customElement
 * @polymer
 */
class VistaPedidospendientes extends PolymerElement {

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
        return 'vista-pedidospendientes';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaPedidospendientes.is, VistaPedidospendientes);
