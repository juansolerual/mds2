import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-elementoscomunescarrito`
 *
 * VistaElementoscomunescarrito element.
 *
 * @customElement
 * @polymer
 */
class VistaElementoscomunescarrito extends PolymerElement {

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
        return 'vista-elementoscomunescarrito';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaElementoscomunescarrito.is, VistaElementoscomunescarrito);
