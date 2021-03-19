import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `vista-usuarioregistrado`
 *
 * VistaUsuarioregistrado element.
 *
 * @customElement
 * @polymer
 */
class VistaUsuarioregistrado extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;

                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; flex-direction: column; align-items: flex-start; justify-content: flex-start;" id="verticalLayout"></vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-usuarioregistrado';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaUsuarioregistrado.is, VistaUsuarioregistrado);
