import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaVisualizarpantalla extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; flex-direction: column; align-items: center; justify-content: flex-start;" id="verticualLayout">
 <vaadin-horizontal-layout id="horizontalSplit" style="width: 100%; flex-direction: row; flex-wrap: wrap; justify-content: flex-start; align-items: flex-start;"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-visualizarpantalla';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVisualizarpantalla.is, VistaVisualizarpantalla);
