import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-elementos_comunes_carrito`
 *
 * VistaElementos_comunes_carrito element.
 *
 * @customElement
 * @polymer
 */
class VistaElementos_comunes_carrito extends PolymerElement {

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
        return 'vista-elementos_comunes_carrito';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaElementos_comunes_carrito.is, VistaElementos_comunes_carrito);
