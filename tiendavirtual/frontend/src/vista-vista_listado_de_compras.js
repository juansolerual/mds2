import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-vista_listado_de_compras`
 *
 * VistaVista_listado_de_compras element.
 *
 * @customElement
 * @polymer
 */
class VistaVista_listado_de_compras extends PolymerElement {

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
        return 'vista-vista_listado_de_compras';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVista_listado_de_compras.is, VistaVista_listado_de_compras);
