import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-anuncio`
 *
 * VistaAnuncio element.
 *
 * @customElement
 * @polymer
 */
class VistaAnuncio extends PolymerElement {

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
        return 'vista-anuncio';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaAnuncio.is, VistaAnuncio);
