import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-cabecera_administrador`
 *
 * VistaCabecera_administrador element.
 *
 * @customElement
 * @polymer
 */
class VistaCabecera_administrador extends PolymerElement {

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
        return 'vista-cabecera_administrador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCabecera_administrador.is, VistaCabecera_administrador);
