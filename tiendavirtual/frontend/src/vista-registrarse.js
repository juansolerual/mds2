import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-registrarse`
 *
 * VistaRegistrarse element.
 *
 * @customElement
 * @polymer
 */
class VistaRegistrarse extends PolymerElement {

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
        return 'vista-registrarse';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaRegistrarse.is, VistaRegistrarse);
