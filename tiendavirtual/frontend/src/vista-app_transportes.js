import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-app_transportes`
 *
 * VistaApp_transportes element.
 *
 * @customElement
 * @polymer
 */
class VistaApp_transportes extends PolymerElement {

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
        return 'vista-app_transportes';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaApp_transportes.is, VistaApp_transportes);
