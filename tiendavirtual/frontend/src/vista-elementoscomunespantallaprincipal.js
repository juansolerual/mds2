import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-elementoscomunespantallaprincipal`
 *
 * VistaElementoscomunespantallaprincipal element.
 *
 * @customElement
 * @polymer
 */
class VistaElementoscomunespantallaprincipal extends PolymerElement {

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
        return 'vista-elementoscomunespantallaprincipal';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaElementoscomunespantallaprincipal.is, VistaElementoscomunespantallaprincipal);
