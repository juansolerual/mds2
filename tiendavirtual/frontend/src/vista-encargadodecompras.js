import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-encargadodecompras`
 *
 * VistaEncargadodecompras element.
 *
 * @customElement
 * @polymer
 */
class VistaEncargadodecompras extends PolymerElement {

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
        return 'vista-encargadodecompras';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaEncargadodecompras.is, VistaEncargadodecompras);
