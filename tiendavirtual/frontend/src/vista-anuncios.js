import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-anuncios`
 *
 * VistaAnuncios element.
 *
 * @customElement
 * @polymer
 */
class VistaAnuncios extends PolymerElement {

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
        return 'vista-anuncios';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaAnuncios.is, VistaAnuncios);
