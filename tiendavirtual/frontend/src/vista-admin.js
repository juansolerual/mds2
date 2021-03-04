import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-admin`
 *
 * VistaAdmin element.
 *
 * @customElement
 * @polymer
 */
class VistaAdmin extends PolymerElement {

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
        return 'vista-admin';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaAdmin.is, VistaAdmin);
