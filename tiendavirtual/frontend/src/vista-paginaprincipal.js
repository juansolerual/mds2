import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-paginaprincipal`
 *
 * VistaPaginaprincipal element.
 *
 * @customElement
 * @polymer
 */
class VistaPaginaprincipal extends PolymerElement {

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
        return 'vista-paginaprincipal';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaPaginaprincipal.is, VistaPaginaprincipal);
