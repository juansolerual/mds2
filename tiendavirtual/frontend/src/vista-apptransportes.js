import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-apptransportes`
 *
 * VistaApptransportes element.
 *
 * @customElement
 * @polymer
 */
class VistaApptransportes extends PolymerElement {

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
        return 'vista-apptransportes';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaApptransportes.is, VistaApptransportes);
