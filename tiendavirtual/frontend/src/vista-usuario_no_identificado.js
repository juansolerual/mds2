import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-usuario_no_identificado`
 *
 * VistaUsuario_no_identificado element.
 *
 * @customElement
 * @polymer
 */
class VistaUsuario_no_identificado extends PolymerElement {

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
        return 'vista-usuario_no_identificado';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaUsuario_no_identificado.is, VistaUsuario_no_identificado);
