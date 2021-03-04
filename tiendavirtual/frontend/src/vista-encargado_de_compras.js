import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-encargado_de_compras`
 *
 * VistaEncargado_de_compras element.
 *
 * @customElement
 * @polymer
 */
class VistaEncargado_de_compras extends PolymerElement {

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
        return 'vista-encargado_de_compras';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaEncargado_de_compras.is, VistaEncargado_de_compras);
