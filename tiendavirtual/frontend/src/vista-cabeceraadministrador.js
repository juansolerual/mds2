import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-cabeceraadministrador`
 *
 * VistaCabeceraadministrador element.
 *
 * @customElement
 * @polymer
 */
class VistaCabeceraadministrador extends PolymerElement {

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
        return 'vista-cabeceraadministrador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCabeceraadministrador.is, VistaCabeceraadministrador);
