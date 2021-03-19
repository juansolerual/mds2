import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-listadodecompras`
 *
 * VistaListadodecompras element.
 *
 * @customElement
 * @polymer
 */
class VistaListadodecompras extends PolymerElement {

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
        return 'vista-listadodecompras';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListadodecompras.is, VistaListadodecompras);
