import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-centrodemensajesadministrador`
 *
 * VistaCentrodemensajesadministrador element.
 *
 * @customElement
 * @polymer
 */
class VistaCentrodemensajesadministrador extends PolymerElement {

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
        return 'vista-centrodemensajesadministrador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCentrodemensajesadministrador.is, VistaCentrodemensajesadministrador);
